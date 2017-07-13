/**=========================================================
 * Module: user-block-status.js
 * Used for the dropdown in the sidebar to change
 * the user status
 =========================================================*/

(function($, window, document){

  var Selector =  '.user-block-status';

  $(document).on('click', Selector, function(e) {

    // avoids conflict with menu collapse
    e.stopPropagation();

    var $this = $(this),
        html = $this.find('.dropdown-menu > li > a').filter(e.target).html(), // the status clicked
        btn  = $this.find('.btn'); // the button to display status
    
    // Update button status
    btn.html(html);

    // Update picture status indicator
    $('.user-block .user-block-picture .user-block-status').html(html);
    
    // Since we stopPropagation dropdown must be closed manually
    if($this.hasClass('open'))
      btn.dropdown('toggle');
    
  });

}(jQuery, window, document));
