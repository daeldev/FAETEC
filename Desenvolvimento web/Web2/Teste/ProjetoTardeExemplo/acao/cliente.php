<?php
    include("../conexao.php");
    include("alertas.php");

    if(isset($_POST['id'])) $id=$_POST['id'];
    if(isset($_POST['nome'])) $nome = $_POST['nome'];
    if(isset($_POST['tel'])) $tel = $_POST['tel'];
    if(isset($_POST['email'])) $email = $_POST['email'];

    if(isset($_POST['set'])) $set = $_POST['set'];
    if(isset($_GET['id'])) $id=$_GET['id'];
    if(isset($_GET['set'])) $set = $_GET['set'];

    if($set=="ad"){
        // Adicionar o registro do novo cliente
        $insere_pdo = $conexao_pdo->prepare("INSERT INTO clientes 
                                             (nomeCliente,telCliente,emailCliente)
                                             VALUES (?, ?, ?)");
        $insere_pdo->execute(array($nome, $tel, $email));
        // Chama a função para atertar sobre a inclusão do novo cliente e retorna a tela clientes
        sets();
    }elseif($set=="up"){
        // Altero registro do cliente selecionado
        $altera_pdo = $conexao_pdo->prepare("UPDATE clientes 
                                             SET nomeCliente=?,telCliente=?,emailCliente=?
                                             WHERE idCliente=?");
        $altera_pdo->execute(array($nome,$tel,$email,$id));
        //Chama função para alerta de alteração e retorna a tela clientes
        ups();
    }elseif($set=="del"){
        // Deleto registro do cliente selecionado
        $deleta_pdo = $conexao_pdo->prepare("DELETE FROM clientes WHERE idCliente='$id'");
        $deleta_pdo->execute();
        // Chama função para alertar sobre a exclusão e retornar a tela clientes
        avisodel();
    }
?>