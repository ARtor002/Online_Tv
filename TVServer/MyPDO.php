<?php
class MyPDO extends PDO
{

    private static $instance = null;

    public function __construct()
    {
        try{
        parent::__construct("mysql:host=localhost;dbname=tv", "root", "");
        self::$instance = $this;
        self::$instance->exec("SET NAMES utf8");
        self::$instance->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);  
        } catch(Exception $exp){
            echo "Error: ".$exp->getMessage();
        }
    }

    public static function getInstance()
    {
        if (self::$instance == null) {
            self::$instance = new MyPDO();
        }
        return self::$instance;
    }
}