$(document).ready(function () {
    $("[id^=file-]").on('change', function(){
        var imgItem = $(this)[0].files;
        var imgCount = $(this)[0].files.length;
        var imgPath = $(this)[0].value;
        var imgExt = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
        var idSelector ='#imgpreview-' +  $(this).attr('data-id');
        var imgpreview = $(idSelector);
        imgpreview.empty();
        if ((imgExt == "gif" || imgExt == "png" || imgExt == "jpg" || imgExt == "bmp" || imgExt == "jpeg" ) && imgCount<=10) {
            if (typeof(FileReader) != "undefined" ) {
                for (var i = 0; i < imgCount; i++) {
                    var reader = new FileReader();
                    var fn = imgItem[i].name;
                    var fs = imgItem[i].size;
                    var ft = imgItem[i].type;
                    reader.onload = function (e) {
                        $("<img/>", {
                            "src": e.target.result,
                            "width": "150",
                            "height": "150",
                            "class": "imgClass",
                            "title": fn + " and size" + fs + "bytes and type" + ft,
                            "alt": fn + " and size" + fs + "bytes and type" + ft
                        }).appendTo(imgpreview)
                    }
                    imgpreview.show();
                    reader.readAsDataURL($(this)[0].files[i]);
                }
            } else {
                imgpreview.html("Неверный тип или кол-во превышает допустимое")
            }
        } else {

            imgpreview.html("Неверный формат");

        }
    });
});