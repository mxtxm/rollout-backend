<?php
$fileName = $argv[3];
$width = $argv[4];

function resizeImage($filename) {
    list($oWidth, $oHeight) = getimagesize($filename);

    if ($oWidth > $oHeight) {
        $width = 1200;
    } else {
        $width = 900;
    }

    if ($oWidth < $width) {
        $oWidth = $width - 5;
    }

    switch (pathinfo($filename)['extension']) {
        case "png":
            return imagepng(imagescale(imagecreatefrompng($filename), $width), $filename);
        case "gif":
            return imagegif(imagescale(imagecreatefromgif($filename), $width), $filename);
        default :
            return imagejpeg(imagescale(imagecreatefromjpeg($filename), $width), $filename);
    }
}
