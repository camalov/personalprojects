<?php 

include 'baglan.php';

if(isset($_POST['esas_sehife_data'])){

	$esas_sehife_id=1;

	$data_elave=mysql_query("update esas_sehife set sehife_basliq='".$_POST['sehife_basliq']."', sehife_mezmunu='".$_POST['sehife_mezmunu']."', sehife_metin='".$_POST['xeber_mezmunu']."' where esas_sehife_id='".$esas_sehife_id."' ");

	if(mysql_affected_rows()){

		header('Location:../index.php?operation=ok');

	}else{

		header('Location:../index.php?operation=no');
	
	}
}

if(isset($_POST['parametrsaxla'])){

	$id=0;

	$yaddasaxla=mysql_query("update parametrler set parametr_title='".$_POST['parametr_title']."',parametr_description='".$_POST['parametr_description']."',parametr_keywords='".$_POST['parametr_keywords']."',parametr_telefon='".$_POST['parametr_telefon']."',parametr_facebook='".$_POST['parametr_facebook']."',parametr_twitter='".$_POST['parametr_twitter']."',parametr_footer='".$_POST['parametr_footer']."',parametr_unvan='".$_POST['parametr_unvan']."',parametr_mail='".$_POST['parametr_mail']."',parametr_fax='".$_POST['parametr_fax']."',parametr_olke='".$_POST['parametr_olke']."' where parametr_id='$id' ");



if(mysql_affected_rows())
{
	header('Location:../parametrler.php?saxlandi=ok');
}
else{

	header('Location:../parametrler.php?saxlandi=no');

}

}

// Asagi hisse inzibatci bolmesinin login daxil, cixis olma hissesidir....

if(isset($_POST['userinfo'])){

$admin_login=$_POST['admin_login'];
$admin_sifre=md5($_POST['admin_sifre']);

 if($admin_login && $admin_sifre)
 {

 	$yoxla=mysql_query("select * from admin where admin_login='$admin_login' and admin_sifre='$admin_sifre' ");
 	
 	$adminsay=mysql_num_rows($yoxla);

 
 	if($adminsay>0)
 	{

 		$_SESSION['userinfo']=$admin_login;

 		header("Location:../index.php?login=ok");
 	
 	}

 	   	else{

 		header("Location:../login.php?login=no");


 	}


  }
}

/*Asagi hisse menyularla bagli alqoritmlerdir  */

if(isset($_POST['elave_et'])){


	$elaveet=mysql_query("insert into menyular (menyu_ad, menyu_url) VALUES ('".$_POST['menyu_ad']."','".$_POST['menyu_url']."') ");


	if(mysql_affected_rows())
	{

		header("Location:../menyu-elave.php?saxlandi=ok");
	}

else{

	header("Location:../menyu-elave.php?saxlandi=no");

}


}


if(isset($_POST['deyisdir'])){


	$menyu_id=$_POST['menyu_id'];

	$deyisdir=mysql_query("update menyular set menyu_ad='".$_POST['menyu_ad']."', menyu_url='".$_POST['menyu_url']."' where menyu_id='$menyu_id' ");


	if(mysql_affected_rows())
	{

		header("Location:../menyu-deyisdir.php?saxlandi=ok&menyu_id=$menyu_id");
	}

else{

	header("Location:../menyu-deyisdir.php?saxlandi=no&menyu_id=$menyu_id");

}


}

if($_GET['menyusilindi']==ok){


	$sil=mysql_query("delete from menyular where menyu_id='".$_GET['menyu_id']."' ");

	if(mysql_affected_rows()){


		header("Location:../menyular.php?menyu-silindi=ok");
	}

	else{

		header("Location:../menyular.php?menyu-silindi=no");

	}


}

/*Menyularla bagli olan hisse yuxarida qaldi*/


/*Asagi hisseden etibaren slayd funksiyalari baslayir */

 if($_POST['slider_elave_et']) {

	$yerlesmeunvani='../uploads/sliderphoto';

	@$tmp_name = $_FILES['slider_sekil']["tmp_name"];
	@$name = $_FILES['slider_sekil']["name"];

	$randed1=rand(1, 900000);
	$randed2=rand(1, 900000);
	$randed3=rand(1, 900000);
	$randed4=rand(1, 900000);
	$randed5=rand(1, 900000);
	$randed6=rand(1, 900000);
	$randed7=rand(1, 900000);

	$ferqliad=$randed1.$randed2.$randed3.$randed4.$randed5.$randed6.$randed7;
	$slider_sekilyolu=substr($yerlesmeunvani, 3)."/"."$ferqliad"."$name";

	@move_uploaded_file("$tmp_name", "$yerlesmeunvani/$ferqliad$name");



	$slider_elave_et=mysql_query("insert into slider (slider_ad, slider_sekilyolu, slider_url, slider_sira) VALUES ('".$_POST['slider_ad']."', '".$slider_sekilyolu."', '".$_POST['slider_url']."', '".$_POST['slider_sira']."') ");


	if(mysql_affected_rows()){

		header("Location:../slayd-elave.php?saxlandi=ok");
	
	} else{

		header("Location:../slayd-elave.php?saxlandi=no");
	}


} 

if($_POST['slayd_silinme_id']){

	/*	echo $_GET['$slider_id']; */
	
	$slaydyolu=$_POST['slider_sekilyolu'];

	$imgdel=unlink("../".$slaydyolu);

	$slider_sil=mysql_query("delete from slider where slider_id='".$_POST['slayd_silinme_id']."' ");

	if(mysql_affected_rows()){


		header("Location:../slayd.php?slayd-silindi=ok");
	}

	else{

		header("Location:../slayd.php?slayd-silindi=no");

	}

}


if($_POST['slayd-deyisdir']){

$slayddeyis=mysql_query("update slider set slider_ad='".$_POST['slider_ad']."', slider_url='".$_POST['slider_url']."', slider_sira='".$_POST['slider_sira']."' where  slider_id='".$_POST['slider_id']."' ");
	


	if(mysql_affected_rows()){

		header("Location:../slayd-deyisdir.php?slayd-deyisdi=ok");
	
	} else{


		header("Location:../slayd-deyisdir.php?slayd-deyisdi=no");

	}


}

if($_POST['slayd-movzu-deyisdir']){

	$yerlesmeunvani='../uploads/sliderphoto';

	$tmp_name = $_FILES['slider_sekil']["tmp_name"];
	$name = $_FILES['slider_sekil']["name"];

	$randed1=rand(1, 900000);
	$randed2=rand(1, 900000);
	$randed3=rand(1, 900000);
	$randed4=rand(1, 900000);
	$randed5=rand(1, 900000);
	$randed6=rand(1, 900000);
	$randed7=rand(1, 900000);

	$ferqliad=$randed1.$randed2.$randed3.$randed4.$randed5.$randed6.$randed7;
	$slider_sekilyolu=substr($yerlesmeunvani, 3)."/"."$ferqliad"."$name";
	

	@move_uploaded_file("$tmp_name", "$yerlesmeunvani/$ferqliad$name");


	if(!@$name){


		$slider_sekilyolu=$_POST['slider_sekilyolu'];
		$yenisekil=mysql_query("update slider set slider_sekilyolu='".$slider_sekilyolu."' where slider_id='".$_POST['slider_id']."' ");
		header("Location:../slayd-movzu-deyis.php?saxlandi=no");
	
	}
	else{

		$olddel=unlink("../".$_POST['slider_sekilyolu']);
		$yenisekil=mysql_query("update slider set slider_sekilyolu='".$slider_sekilyolu."' where slider_id='".$_POST['slider_id']."' ");

	}


	if(mysql_affected_rows()){

		header("Location:../slayd-movzu-deyis.php?saxlandi=ok");
	}else{


		header("Location:../slayd-movzu-deyis.php?saxlandi=no");
	}


}

// Asagi hisse sehifelerle bagli hissedir

if($_POST['sehife-elave']){

	$zaman=date('Y-m-d H:i');

	$sehife_elave=mysql_query("insert into sehifeler (sehife_ad, sehife_mezmunu, sehife_sira, basic_page, sehife_tarixi) VALUES ('".$_POST['sehife_ad']."', '".$_POST['sehife_mezmunu']."', '".$_POST['sehife_sira']."', '".$_POST['basic_page']."', '".$zaman."') ");


	if(mysql_affected_rows()){

		header("Location:../sehife-elave.php?saxlandi=ok");

	}else{

		header("Location:../sehife.php?saxlandi=no");


	}

}

if($_GET['sehifesilindi']==ok){

	$sehife_sil=mysql_query("delete from sehifeler where sehife_id='".$_GET['sehife_id']."' ");

	if(mysql_affected_rows()){

		header("Location:../sehifeler.php?silindi=ok");

	}else{

		header("Location:../sehifeler.php?silindi=no");

	}

}

if($_POST['sehife-redakte']){

	$yenile=mysql_query("update sehifeler set sehife_ad='".$_POST['sehife_ad']."', sehife_mezmunu='".$_POST['sehife_mezmunu']."', sehife_sira='".$_POST['sehife_sira']."', basic_page='".$_POST['basic_page']."' where sehife_id='".$_POST['sehife_id']."' ");

	$sehife_id=$_POST['sehife_id'];

	if(mysql_affected_rows()){

		header("Location:../sehife-redakte.php?saxlandi=ok&sehife_id=$sehife_id");

	}else{

		header("Location:../sehife-redakte.php?saxlandi=no&sehife_id=$sehife_id");

	}

}

// asagi hisse xeberlerle bagli hissedir

if($_GET['xeber_silindi']=='ok'){

	$xeber_id=$_GET['xeber_id'];
	$xeber_sekilyolu=$_POST['xeber_sekilyolu'];
	$sil=unlink('../'.$_POST['xeber_sekilyolu']);

	$xeber_sil=mysql_query("delete from xeberler where xeber_id='".$_GET['xeber_id']."' ");

	if(mysql_affected_rows()){

		header("Location:../xeberler.php?xeber_silindi=ok");

	}else{

		header("Location:../xeberler.php?xeber_silindi=no");

	}

}



if(isset($_POST['xeber_elave_et'])){

		

		$sekil_yolu='../uploads/newsphoto';

		$tmp_name=$_FILES['xeber_sekil']["tmp_name"];
		$name=$_FILES['xeber_sekil']["name"];
			
		$randed1=rand(1, 900000);
		$randed2=rand(1, 900000);
		$randed3=rand(1, 900000);
		$randed4=rand(1, 900000);
		$randed5=rand(1, 900000);
		$randed6=rand(1, 900000);
		$randed7=rand(1, 900000);

		$ferqliad=$randed1.$randed2.$randed3.$randed4.$randed5.$randed6.$randed7;
	
		$sekil_ad=substr($sekil_yolu, 3)."/"."$ferqliad"."$name";

		move_uploaded_file("$tmp_name", "$sekil_yolu/$ferqliad$name");
	
		

 	

 	$yuklenme_zamani=date('Y-m-d H:i');

 	$xeber_elave=mysql_query("insert into xeberler (xeber_ad, xeber_mezmunu, xeber_tarix, xeber_sekilyolu) VALUES('".$_POST['xeber_ad']."', '".$_POST['xeber_mezmunu']."', '".$yuklenme_zamani."', '".$sekil_ad."') ");		


  if(mysql_affected_rows()){


	header("Location:../xeber-elave.php?saxlandi=ok");
	 }else{

		header("Location:../xeber-elave.php?saxlandi=no");
	}


}

if(isset($_POST['xeber_redakte'])){

	$xeber_id=$_POST['xeber_id'];

	$xeber_redakte=mysql_query("update xeberler set xeber_ad='".$_POST['xeber_ad']."', xeber_mezmunu='".$_POST['xeber_mezmunu']."' where xeber_id='".$_POST['xeber_id']."' ");


	if(mysql_affected_rows()){


	header("Location:../xeber-redakte.php?saxlandi=ok&xeber_id=$xeber_id");
	 }else{

		header("Location:../xeber-redakte.php?saxlandi=no&xeber_id=$xeber_id");
	}

}

// Asagi hisse elaqe bolmesidir...

if(isset($_POST['contact_form'])){
	 
	date_default_timezone_set('Asia/Baku');
	$time=date("Y-m-d H:i");
	
	$elave_et=mysql_query("insert into elaqe (message_ad, message_email, message_telefon, message_movzu, message, upload_time) VALUES ('".$_POST['ad']."', '".$_POST['mail']."', '".$_POST['nomre']."', '".$_POST['movzu']."', '".$_POST['mesaj']."', '".$time."')");
	
	if(mysql_affected_rows()){
		
		header("Location:../../elaqe.php?operation=ok&message_id=");
	}else{
		header("Location:../../elaqe.php?operation=no");
	}

}

if($_GET['mesaj_silindi']=='ok'){

	$message_id=$_GET['message_id'];
	$mesaj_sil=mysql_query("delete from elaqe where message_id='".$message_id."' ");

	if(mysql_affected_rows()){

		header("Location:../message.php?mesaj_silindi=ok");
	}else{
		header("Location:../message.php?mesaj_silindi=no");
	}
}
?>
</form>
<?
// xidmetler bolmesine aid hisse.

if(isset($_POST['xidmet-elave'])){

	$xidmet_elave=mysql_query("insert into xidmetler (xidmet_ad, xidmet_haqqi, xidmet_upload_time) VALUES ('".$_POST['xidmet_ad']."', '".$_POST['xidmet_haqqi']."', '".$_POST['xidmet_zaman']."') ");

	$xidmet_sorgu=mysql_query("select * from xidmetler where xidmet_upload_time='".$_POST['xidmet_zaman']."' ");
	$xidmet_get=mysql_fetch_assoc($xidmet_sorgu);
	$xidmet_id=$xidmet_get['xidmet_id'];

	if(mysql_affected_rows()){

		header("Location:../xidmet-elave.php?saxlandi=ok&xidmet_id=$xidmet_id");
	}else{

		header("Location:../xidmet-elave.php?saxlandi=no&xidmet_id=$xidmet_id");
	}

}

if(isset($_POST['xidmet-redakte'])){

	
	$xidmet_id=$_POST['xidmet_id'];
	
	$xidmet_redakte=mysql_query("update xidmetler set xidmet_ad='".$_POST['xidmet_ad']."', xidmet_haqqi='".$_POST['xidmet_haqqi']."', xidmet_upload_time='".$_POST['xidmet_zaman']."' where xidmet_id='".$xidmet_id."' ");

	if(mysql_affected_rows()){

		header("Location:../xidmet-elave.php?saxlandi=ok&xidmet_id=$xidmet_id");
	}else{

		header("Location:../xidmet-elave.php?saxlandi=ok&xidmet_id=$xidmet_id");
	}

}

if($_GET['xidmetsilindi']=='ok'){

	$xidmet_id = $_GET['xidmet_id'];

	$xidmet_sil=mysql_query("delete from xidmetler where xidmet_id='".$xidmet_id."' ");

	if(mysql_affected_rows()){

		header("Location:../xidmetler.php");
	}else{

		header("Location:../xidmetler.php&xidmetsilindi=no");
	}

}

?>