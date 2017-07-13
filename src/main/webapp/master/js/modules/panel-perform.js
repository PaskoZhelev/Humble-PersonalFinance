/**=========================================================
 * Module: panel-perform.js
 * Dismiss panels
 * [data-perform="panel-dismiss"]
 *
 * Requires animo.js
 =========================================================*/
(function($, window, document){
  
  var panelSelector = '[data-perform="panel-dismiss"]';

  $(document).on('click', panelSelector, function (e) {
    
    // find the first parent panel
    var parent = $(this).closest('.panel');

    if($.support.animation) {
      parent.animo({animation: 'bounceOut'}, removeElement);
    }
    else removeElement();

    function removeElement() {
      var col = parent.parent();
      parent.remove();
      // remove the parent if it is a row and is empty
      col.filter(function() {
        var el = $(this);
        return (el.is('[class*="col-"]') && el.children('*').length === 0);
      }).remove();

    }

  });

}(jQuery, window, document));


/**
 * Collapse panels
 * [data-perform="panel-collapse"]
 */
(function($, window, document){
  
  var panelSelector = '[data-perform="panel-collapse"]';

  // Prepare the panel to be collapsable and its events
  $(panelSelector).each(function() {
    // find the first parent panel
    var $this = $(this),
        parent = $this.closest('.panel'),
        wrapper = parent.find('.panel-wrapper'),
        collapseOpts = {toggle: false};
    
    // if wrapper not addded, add it
    // we need a wrapper to avoid jumping due to the paddings
    if( ! wrapper.length) {
      wrapper =
        parent.children('.panel-heading').nextAll() //find('.panel-body, .panel-footer')
          .wrapAll('<div/>')
          .parent()
          .addClass('panel-wrapper');
      collapseOpts = {};
    }
    // Init collapse and bind events to switch icons
    wrapper
      .collapse(collapseOpts)
      .on('hide.bs.collapse', function() {
        $this.children('em').removeClass('fa-minus').addClass('fa-plus');
      })
      .on('show.bs.collapse', function() {
        $this.children('em').removeClass('fa-plus').addClass('fa-minus');
      });

  });
  // finally catch clicks to toggle panel size
  $(document).on('click', panelSelector, function (e) {
    
    var parent = $(this).closest('.panel');
    var wrapper = parent.find('.panel-wrapper');

    wrapper.collapse('toggle');

  });

}(jQuery, window, document));


/**
 * Refresh panels
 * [data-perform="panel-refresh"]
 * [data-spinner="standard"]
 */
(function($, window, document){
  
  var panelSelector  = '[data-perform="panel-refresh"]',
      refreshEvent   = 'panel-refresh',
      csspinnerClass = 'csspinner',
      defaultSpinner = 'standard';

  // method to clear the spinner when done
  function removeSpinner() { this.removeClass(csspinnerClass); }

  // catch clicks to toggle panel refresh
  $(document).on('click', panelSelector, function (e) {
      var $this   = $(this),
          panel   = $this.parents('.panel').eq(0),
          spinner = $this.data('spinner') || defaultSpinner
          ;

      // start showing the spinner
      panel.addClass(csspinnerClass + ' ' + spinner);

      // attach as public method
      panel.removeSpinner = removeSpinner;

      // Trigger the event and send the panel object
      $this.trigger(refreshEvent, [panel]);

  });


  /**
   * This function is only to show a demonstration
   * of how to use the panel refresh system via 
   * custom event. 
   * IMPORTANT: see how to remove the spinner.
   */

  $('.panel.panel-demo').on('panel-refresh', function(e, panel){
    
    // perform any action when a .panel triggers a the refresh event
    setTimeout(function(){
  
      // when the action is done, just remove the spinner class
      panel.removeSpinner();
  
    }, 3000);

  });

}(jQuery, window, document));
