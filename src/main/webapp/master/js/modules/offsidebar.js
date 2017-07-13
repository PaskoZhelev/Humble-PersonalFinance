/**=========================================================
 * Module: offsidebar.js
 * Show content inside an offcanvas box
 =========================================================*/

(function($, window, document){

  var triggerSelector      = '[data-toggle="offsidebar"]',
      offsidebarSelector   = '.offsidebar',
      offsidebarOpenClass  = 'offsidebar-open',
      $body = $('body');

  $(function() {
    
    var OffSidebar = {
      open: function(offsidebar) {
        $body.addClass(offsidebarOpenClass);
      },
      close: function() {
        $body.removeClass(offsidebarOpenClass);
      },
      toggle: function() {
        $body.toggleClass(offsidebarOpenClass);
      }
    };

    $(document)
        .on("click", OffSidebar.close)
        .on("click", offsidebarSelector + "," + triggerSelector, function (e) {
          e.stopPropagation();
        })
        .on("click", triggerSelector, OffSidebar.toggle);

  });

}(jQuery, window, document));
