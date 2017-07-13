/**=========================================================
 * Module: sparkline.js
 * SparkLines Mini Charts
 =========================================================*/

(function($, window, document){

  var Selector = '.inlinesparkline';

  // Match color with css values to style charts
  var colors = {
        primary:         '#5fb5cb',
        success:         '#27ae60',
        info:            '#22bfe8',
        warning:         '#ffc61d',
        danger:          '#f6504d'
    };

  // Inline sparklines take their values from the contents of the tag 
  $(Selector).each(function() {

      var $this = $(this);
      var data = $this.data();

        if(data.barColor && colors[data.barColor])
          data.barColor = colors[data.barColor];

      var options = data;
      options.type = data.type || 'bar'; // default chart is bar

      $(this).sparkline('html', options);

  });

}(jQuery, window, document));
