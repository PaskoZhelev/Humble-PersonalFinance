/**=========================================================
 * Module: datepicker,js
 * DateTime Picker init
 =========================================================*/

(function($, window, document){

    var Selector = '.datetimepicker';

    $(Selector).each(function() {

      var $this = $(this),
          options = $this.data(); // allow to set options via data-* attributes
      
      $this.datetimepicker($.extend(
        options,
        { // support for FontAwesome icons
          icons: {
              time:   "fa fa-clock-o",
              date:   "fa fa-calendar",
              up:     "fa fa-arrow-up",
              down:   "fa fa-arrow-down"
          }
        }));

      // Force a dropdown hide when click out of the input
      $(document).on('click', function(){
        $this.data("DateTimePicker").hide();
      });

    });

}(jQuery, window, document));
