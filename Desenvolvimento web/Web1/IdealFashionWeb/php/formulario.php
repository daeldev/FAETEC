<?php
    ini_set('display_errors', 1)
    ini_set('display_startup_errors', 1)

    if($_SERVER["REQUEST_METHOD"] == "POST"){
        $name = htmlspecialchars($_POST['name']);
        $senha = htmlspecialchars($_POST['senha']);

        if(empty($name) || empty($senha)){
            header("Location: index.html?status=error");
            exit;
        }       
        header("Location: sucesso.html?status=invalid");
        exit;
    }else{
        header("Location: index.html?status=error");
        exit;
    }
?>