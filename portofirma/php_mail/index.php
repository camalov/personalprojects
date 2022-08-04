<?php

require 'phpmailer/PHPMailerAutoload.php';

$mail = new PHPMailer();

$mail->isSMTP();
$mail->Host = "smtp.gmail.com";
$mail->SMTPSecure = "ssl";
$mail->Port = 465;
$mail->SMTPAuth = true;
$mail->Username = 'cmilcamalov2000@gmail.com';
$mail->Password = '123456789Az';

$mail->setFrom('cmilcamalov2000@gmail.com', 'Jay Meel');
$mail->addAddress('cmil_camalov@c-datasoftware.tk');
$mail->Subject = 'SMTP email test';
$mail->Body = 'this is some body';

if ($mail->send()){
    echo "Mail sent";
}
else{
	echo "Mesaj gonderilmedi";
}

?>