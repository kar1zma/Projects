 <?php
 

class User{
	private $user_id, $screen_name, $f_name, $l_name, $email, $password, $curr_chat_id, $fb_id, $guid, $db;
	public function __construct($screen_name, $guid)
		{
			$this->screen_name = $screen_name;
			$this->guid = $guid;
			$this->db = new mysqli('pseudocodingnet.fatcowmysql.com', 'kittenfire', '128411', 'chatengine');
			if(!$this->db){
				echo "Cannot connect to db"; 
				die();	
			}
			$this->setupCredentials();
		}	
		
	/**
	If the username and password are correct, returns a User object, otherwise it returns NULL.
	**/
	public static function login($screenname, $pw)
	{
		$hashPW = md5($pw);
		$db = new mysqli('pseudocodingnet.fatcowmysql.com', 'kittenfire', '128411', 'chatengine');
		if(!$db){
			echo "Could not connect";
			die();
		}
		//Creates a new GUID every attempt to login to prevent hackers from hacking the place!
		$guid = uniqid('', true);
		$db->query("update Members set guid='$guid' where screen_name='$screenname'"); 
		
		//Check to see if the user exists with the username and pw..
		$stmt = $db->prepare("select screen_name from Members where screen_name = ? and password = ? ");
		$stmt->bind_param('ss', $screenname, $hashPW);
		$stmt->execute();
		$stmt->bind_result($screen_name);
		if($stmt->fetch())
		{
			return new User($screenname, $guid);
		}
		else
		{
			//echo "FUCK YOU HACKER";//lol.
			return NULL;
		}
	}
	
	/***********************************************************************
	 If me_id is correct, will return a User object.
	 Otherwise, will return null (and call you a fucking hacker).
	************************************************************************/
	public static function fb_login($me_id){
		$db = new mysqli('pseudocodingnet.fatcowmysql.com', 'kittenfire', '128411', 'chatengine');
		if(!$db){
			echo "Could not connect";
			die();
		}
		//Creates a new GUID every attempt to login to prevent hackers from hacking the place!
		$guid = uniqid('', true);
		$db->query("update Members set guid='$guid' where fb_id='$me_id'"); 
		
		//Check to see if the user exists with the username and pw..
		$stmt = $db->prepare("select screen_name from Members where fb_id=? ");
		$stmt->bind_param('i', $me_id);
		$stmt->execute();
		$stmt->bind_result($screen_name);
		if($stmt->fetch())
		{
			return new User($screen_name, $guid);
		}
		else
		{
			//echo "FUCK YOU HACKER";//lol.
			return NULL;
		}
	}
	
	/***************************************************************************************************************
		Sets up all the private fields of the user. This way we can edit them without having to query from the db every
		2 seconds.
	****************************************************************************************************************/
	private function setupCredentials(){
		$stmt = $this->db->prepare("select * from Members where screen_name = ? AND guid=?");
		$stmt->bind_param('ss',$this->screen_name, $this->guid);
		$stmt->execute();
		$stmt->bind_result($this->user_id, $this->screen_name, $this->f_name, $this->l_name, $this->email, $this->password, $this->curr_chat_id, $this->fb_id, $this->guid);
		if($stmt->fetch()){
			echo "Successfully logged in" . "<br />";
		}
		else{
			echo "Nope, screen_name is ". $this->screen_name . " and guid is: " . $this->guid;	
		}
	}
	public static function createUser($screen_name, $password, $first_name, $last_name, $email){
		if(User::screenNameInDB($screen_name)){
			return json_encode(array("created"=>-1));
		}		
		$db = new mysqli('pseudocodingnet.fatcowmysql.com', 'kittenfire', '128411', 'chatengine');
		$password = md5($password);
		if(!$db){
			echo "Could not connect";
			die();
		}
		$query ="insert into Members(screen_name, f_name, l_name, email, password, curr_chat_id) values(?,?,?,?,?,0)";
		$stmt = $db->prepare($query);
		$stmt->bind_param('sssss',$screen_name, $first_name, $last_name, $email, $password);
		$stmt->execute();
		return json_encode(array("created"=>1));
	}
	public static function createUserFB($screen_name, $fb_id, $first_name, $last_name, $email){
		if(User::screenNameInDB($screen_name)){
			return json_encode(array("created"=>-1));
		}
		if(User::fbInDB($fb_id)){
			return json_encode(array("created"=>0));
		}
		$db = new mysqli('pseudocodingnet.fatcowmysql.com', 'kittenfire', '128411', 'chatengine');
		$password = md5(uniqid('',true));
		if(!$db){
			echo "Could not connect";
			die();
		}
		$query ="insert into Members(screen_name, f_name, l_name, email, password, fb_id,curr_chat_id) values(?,?,?,?,?,?, 0)";
		$stmt = $db->prepare($query);
		$stmt->bind_param('sssssi',$screen_name, $first_name, $last_name, $email, $password, $fb_id);
		$stmt->execute();
		return json_encode(array("created"=>1));
		}
	public static function fbInDB($fb_id){
		$db = new mysqli('pseudocodingnet.fatcowmysql.com', 'kittenfire', '128411', 'chatengine');
		if(!$db){
			echo "Could not connect";
			die();
		}
		$stmt = $db->prepare("select screen_name from Members where fb_id=$fb_id");
		$stmt->execute();
		$stmt->bind_result($screen);
		if($stmt->fetch()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static function screenNameInDB($screen_name){
		$db = new mysqli('pseudocodingnet.fatcowmysql.com', 'kittenfire', '128411', 'chatengine');
		if(!$db){
			echo "Could not connect";
			die();
		}
		$stmt = $db->prepare("select screen_name from Members where screen_name = \"$screen_name\"");
		$stmt->execute();
		$stmt->bind_result($screen);
		if($stmt->fetch()){
			return true;
		}
		else{
			return false;
		}
	}
	public function __toString(){
			return "HELLO";
	}
	public function setUserInterestRating($id, $rating){
		$stmt = $this->db->prepare("insert into Ratings(user_id,int_id,rating) values(?,?,?)");
		$stmt->bind_param('iii', $this->user_id, $id, $rating);
		$stmt->execute();
		$stmt->close();
	}
	public function updateUserInterestRating($id, $rating){
		$uid = $this->user_id;
		$this->db->query("update Ratings set rating = $rating where user_id = $uid AND int_id= $id");
	}
}

//$a = User::fb_login(111); //I manlly edited my username to have this fb_login_id
//echo "Object:" . $a;
/*
if(User::screenNameInDB('PEW')){
	echo "IT IS IN THE DATABASE";
}
else{
	echo "Not in db";
}*/
?>