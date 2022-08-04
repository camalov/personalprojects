-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 04 Kas 2018, 17:44:52
-- Sunucu sürümü: 5.7.17-log
-- PHP Sürümü: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `sales`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `product_purchase_price` double NOT NULL,
  `product_sale_price` double NOT NULL,
  `product_number` int(11) NOT NULL,
  `product_earnings` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `products`
--

INSERT INTO `products` (`product_id`, `product_name`, `product_purchase_price`, `product_sale_price`, `product_number`, `product_earnings`) VALUES
(1, 'a', 3, 32.33, 3, 978);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `statistic`
--

CREATE TABLE `statistic` (
  `statistic_id` int(11) NOT NULL,
  `statistic_product_id` int(11) NOT NULL,
  `statistic_sale_price` double NOT NULL,
  `statistic_sale_num` int(11) NOT NULL,
  `statistic_product_cash` int(11) NOT NULL,
  `statistic_time` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_time` datetime NOT NULL,
  `user_name` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `user_password` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `user_photo_url` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `user_namelastname` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `user_email` varchar(35) COLLATE utf8_turkish_ci NOT NULL,
  `user_mob` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `user_address` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `user_authority` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `user_status` int(1) NOT NULL DEFAULT '1',
  `user_gender` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`user_id`, `user_time`, `user_name`, `user_password`, `user_photo_url`, `user_namelastname`, `user_email`, `user_mob`, `user_address`, `user_authority`, `user_status`, `user_gender`) VALUES
(1, '0000-00-00 00:00:00', 'admin', '098f6bcd4621d373cade4e832627b4f6', '', 'Ad Soyad', 'tes@gmail.com', '', 'Ölkə, Şəhər, Ünvan', '10', 1, 1);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Tablo için indeksler `statistic`
--
ALTER TABLE `statistic`
  ADD PRIMARY KEY (`statistic_id`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT değeri `statistic`
--
ALTER TABLE `statistic`
  MODIFY `statistic_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
