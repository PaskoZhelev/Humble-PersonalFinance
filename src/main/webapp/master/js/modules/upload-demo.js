/**=========================================================
 * Module: upload-demo.js
 * Upload Demostration
 * See file server/upload.php for more details
 =========================================================*/

(function($, window, document){

  $(function() {

    var progressbar = $("#progressbar"),
        bar         = progressbar.find('.progress-bar'),
        settings    = {

            action: 'server/upload.php', // upload url

            allow : '*.(jpg|jpeg|gif|png)', // allow only images

            param: 'upfile',

            loadstart: function() {
                bar.css("width", "0%").text("0%");
                progressbar.removeClass("hidden");
            },

            progress: function(percent) {
                percent = Math.ceil(percent);
                bar.css("width", percent+"%").text(percent+"%");
            },

            allcomplete: function(response) {

                bar.css("width", "100%").text("100%");

                setTimeout(function(){
                    progressbar.addClass("hidden");
                }, 250);

                // Upload Completed
                alert(response);
            }
        };

    var select = new $.upload.select($("#upload-select"), settings),
        drop   = new $.upload.drop($("#upload-drop"), settings);
  });

}(jQuery, window, document));
