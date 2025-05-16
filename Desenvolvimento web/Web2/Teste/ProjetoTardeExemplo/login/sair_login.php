<?php
    // inicia a sessão
    session_start();

    //Destroi a sessão
    $_SESSION=array();
    session_destroy();

    //redireciona para a tela de login
    header('location:../login.html');
?>