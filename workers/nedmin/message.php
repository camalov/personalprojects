<?php include 'header.php';
      include 'netting/baglan.php';
?>
<body>
    <div id="wrapper">
       
        <!-- /. NAV TOP  -->
<?php include 'sidebar.php' ?>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line">Mesaj BÖLMƏSİ</h1>
                        <h1 class="page-subhead-line">Bu səhifədə saytınıza göndərilmiş mesaj'lara nəzarət edə bilərsiniz. </h1>

                    </div>
                </div>
                <!-- /. ROW  -->
              

                <div class="col-md-12">
                     <!--    Context Classes  -->
                    <div class="panel panel-default">
                       
                        <div class="panel-heading">
                            Mesajlar
                        </div>
                        
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Ad</th>
                                            <th>E-Poçt</th>
                                            <th>Telefon</th>
                                            <th style="width:20px";></th>
                                            <th>Mövzu</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php $mesaj_sorgula=mysql_query("select * from elaqe order by message_id DESC"); 

                                              while($mesaj_cek=mysql_fetch_assoc($mesaj_sorgula)){
                                        ?>
                                        <tr <?php if($mesaj_cek['message_read']==0){ ?> class="info" <?php } ?> >
                                            <td><?php echo $mesaj_cek['message_id'] ?></td>
                                            <td><?php echo $mesaj_cek['message_ad'] ?></td>
                                            <td><?php echo $mesaj_cek['message_email'] ?></td>
                                            <td><?php echo $mesaj_cek['message_telefon'] ?></td>
                                            <td style="width:20px"></td>
                                            <td><?php echo substr($mesaj_cek['message_movzu'], 0, 20)."...."; ?></td>  
                                            <td><a href="message-task.php?message_id=<?php echo $mesaj_cek['message_id'] ?>"><button class="btn btn-primary type="" style="margin-right:-19px ">Oxu</button></a></td>
                                            <td><a href="netting/emeliyyatlar.php?message_id=<?php echo $mesaj_cek['message_id'] ?>&mesaj_silindi=ok"<button class="btn btn-danger type="" >Sil</button></a></td>
                                        </tr>
                                        <?php } ?>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--  end  Context Classes  -->
                </div>
            </div>
                <!-- /. ROW  -->

            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->

<?php include 'footer.php' ?>

</body>
</html>
