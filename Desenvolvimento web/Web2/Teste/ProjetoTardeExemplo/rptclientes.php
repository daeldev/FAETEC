<?php
    include("conexao.php");
    include("login/verifica_login.html");
    include("login/redireciona_login.html");

    $usuario = $_SESSION['nome_sessao'];
    
    define('FPDF_FONTPATH','font/');
    require_once("fpdf/fpdf.php");
    //criar uma instância da classe FPDF
    $pdf = new FPDF();
    $pdf->AddPage();
    $pdf->SetTitle("Turma 231 WEB2");
    $pdf->SetFont("courier","B",18);
    $pdf->setx(65);
    $pdf->Cell(30,10,utf8_decode("RELATÓRIO DE CLIENTES"));
    $pdf->SetFont("courier","",14);
    $pdf->ln(10);
    $pdf->Line(15,21,200,21);
    $pdf->setx(15);
    $pdf->Cell(40,10,utf8_decode("CÓDIGO"));
    $pdf->setx(35);
    $pdf->Cell(40,10,"NOME DO CLIENTE");
    $pdf->setx(105);
    $pdf->Cell(40,10,"TELEFONE");    
    $pdf->setx(145);
    $pdf->Cell(40,10,"E-MAIL");    
    $pdf->Line(15,30,200,30);
    $pdf->ln(10);
    $pdf->SetFont("courier","",10);
    //incluir o arquivo de conexão com o banco de dados
    include("conexao.php");
    $verifica_pdo = $conexao_pdo->prepare("SELECT * FROM clientes 
                                           ORDER BY nomeCliente");
    $verifica_pdo->execute();
    $tot = $verifica_pdo->rowCount();
    while($rs=$verifica_pdo->fetch()){
        $pdf->setx(15);
        $pdf->Cell(40,10,$rs['idCliente']);
        $pdf->setx(35);
        $pdf->Cell(40,10,$rs['nomeCliente']);
        $pdf->setx(105);
        $pdf->Cell(40,10,$rs['telCliente']);    
        $pdf->setx(145);
        $pdf->Cell(40,10,$rs['emailCliente']);    
        $pdf->ln(10);     
    }
    $pdf->SetFont("courier","B",12);
    $pdf->setX(15);
    $pdf->SetTextColor(0,0,0);
    $pdf->SetFillColor(225,225,225);
    $pdf->Cell(184,10,'',0,0,'L',true);
    $pdf->setX(15);
    $pdf->Cell(40,10,"TOTAL DE CLIENTES LISTADOS: ".$tot);
    $pdf->Output();
?>