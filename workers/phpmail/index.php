<?php 
ob_start();
session_start();


//1 hafta falan bu mail açık denemelerinizi yapın...
//Eğitimleri sonra izlerseniz kendi hostunuzda deneyin
//localde çalışması için çok çok şey lazım localle uğraşmayın....
$smtpuser="cmilcamalov2000@gmail.com";
$smtphost="mail.post.000webhost.com";
$smtpport="21";
$smtppass="sistemmuhendisleri";



if (isset($_POST['contact_form'])) {
	
	
	$adsoyad = htmlspecialchars(trim($_POST['ad'])); 
	$telefon = htmlspecialchars(trim($_POST['nomre'])); 
	$konu = htmlspecialchars(trim($_POST['movzu'])); 
	$eposta = htmlspecialchars(trim($_POST['mail'])); 
	$mesaj = htmlspecialchars(trim($_POST['mesaj'])); 
	$ip = htmlspecialchars(trim($_POST['iletisim_ip'])); 


	include 'class.phpmailer.php';
	$epoçt_qebul=$smtpuser;
	$mail = new PHPMailer();
	$mail->IsSMTP();
	$mail->SMTPAuth = false;
//	$mail->Host = $smtphost;
//	$mail->Port = $smtpport;
//	$mail->SMTPSecure = 'tls';
//	$mail->Username = $smtpuser;
//	$mail->Password = $smtppass;
	$mail->SetFrom($mail->Username, $adsoyad);
	$mail->AddAddress($epoçt_qebul, $adsoyad);
	//$mail->AddAddress($eposta, $adsoyad);
	$mail->CharSet = 'UTF-8';
	$mail->Subject = 'İletişim Formu';
	$content = '
	<b>Websitenizden gelen iletişim maili</b><br>
	<table align="left" class="tg" style="undefined;table-layout: fixed; width: 535px">

		<tr>
			<td class="tg-031e">Ad Soyad</td>
			<td class="tg-031e">:</td>
			<td class="tg-031e">'.$adsoyad.'</td>
		</tr>
		<tr>
			<td class="tg-031e">Telefon</td>
			<td class="tg-031e">:</td>
			<td class="tg-031e">'.$telefon.'</td>
		</tr>
		<tr>
			<td class="tg-031e">E-Posta</td>
			<td class="tg-031e">:</td>
			<td class="tg-031e">'.$eposta.'</td>
		</tr>
		<tr>
			<td class="tg-031e">Konu</td>
			<td class="tg-031e">:</td>
			<td class="tg-031e">'.$konu.'</td>
		</tr>
		<tr>
			<td class="tg-031e">Mesaj</td>
			<td class="tg-031e">:</td>
			<td class="tg-031e">'.$mesaj.'</td>
		</tr>
		<tr>
			<td class="tg-031e">İp Adresi</td>
			<td class="tg-031e">:</td>
			<td class="tg-031e">'.$ip.'</td>
		</tr>
	</table>';




	$mail->MsgHTML($content);
	if($mail->Send()) {

		header("Location:../index.php?iletisimgonder=ok");
	} 
	else {
			// bir sorun var, sorunu ekrana bastıralım
		header("Location:../index.php?iletisimgonder=no");
	}



}

exit;

?>
