<?php include 'input-security/security.php'; 
      include 'netting/baglan.php';

      $elaqe_sorgula=mysql_query("select * from elaqe where message_read='0' ");
      $elaqe_cek=mysql_num_rows($elaqe_sorgula);
      $admin_sorgula=mysql_query("select * from admin");
      $admin_melumat_cek=mysql_fetch_assoc($admin_sorgula);
?>
 <!-- asagi hisseden sidebar baslayir   -->

        
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <div class="user-img-div">
                            <img src="assets/img/profile.jpeg" class="img-thumbnail" />

                            <div class="inner-text">
                                <?php echo "İnzibatçı: ".$_SESSION['userinfo']?>
                            <br />
                                <small style="margin-left:-30px;">Son daxil olma tarixi : <?php echo $admin_melumat_cek['admin_son_gorulme'] ?></small>
                            </div>
                        </div>

                    </li>

                    <!-- Sidebarda olan siyahilar . mes: Ana sehife, parametr... -->

                    <li>
                        <a class="active-menu" href="index.php"><i class="fas fa-home"></i> Ana səhifə</a>
                    </li>
                    <li>
                        <a class="" href="parametrler.php"><i class="fa fa-cog"></i> Parametrlər</a>
                    </li>
                    <li>
                        <a class="" href="menyular.php"><i class="fa fa-bars"></i> Menyular</a>
                    </li>
                    
                    <?php 
                          $admin = $_SESSION['userinfo'];
                          $admin_sorgula=mysql_query("select * from admin where admin_login='$admin' ");
                          $admin_cek=mysql_fetch_assoc($admin_sorgula);

                          if($admin_cek['admin_selahiyyet']=='0'){
                            
                     ?>

                    <li>
                        <a class="" href="slayd.php"><i class="fas fa-images"></i> Slayd</a>
                    </li>
                    <li>
                        <a class="" href="sehifeler.php"><i class="fas fa-copy"></i> Səhifələr</a>
                    </li>
                    <li>
                        <a class="" href="xeberler.php"><i class="fab fa-blogger-b"></i> Blog</a>
                    </li>
                    <li>
                            <a class="" href="xidmetler.php"><i class="fas fa-building"></i> Xidmətlər</a>
                    </li> 

                    <li>
                        <a class="" href="message.php"><i class="fas fa-envelope"></i> Mesaj<tr><?php if($elaqe_cek>0){ ?>
                            <td><span class="label label-warning"><?php echo $elaqe_cek ?></span></td>
                                    </tr><?php } ?></a>
                    </li> 
                    
                    <?php } ?>

               

                </ul>

            </div>
        </nav>
        

               <!--Sidebar in bitis noqtesi  --> 