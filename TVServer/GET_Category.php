<?php

include "./MyPDO.php";

if(!isset($_REQUEST["type"])){
    die("Error");
}
$type = $_REQUEST["type"];

$conn = MyPDO::getInstance();
$query = $conn->prepare("SELECT * FROM category where type = :type");
$query->bindParam(":type", $type);
$query->execute();
$category = array();
while($temp = $query->fetch(PDO::FETCH_ASSOC)){
    array_push($category, $temp);
}
echo json_encode($category, JSON_UNESCAPED_UNICODE);