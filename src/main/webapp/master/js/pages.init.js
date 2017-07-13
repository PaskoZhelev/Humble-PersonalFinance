(function($, window, document){

  // Document ready
  $(function(){


    // Init Fast click for mobiles
    FastClick.attach(document.body);

    // Hook into accordion show event to add an active class
    // to panel-heading. Used in page login-multi.
    var Selector           = '[data-toggle="collapse-autoactive"]',
        panelHeading       = '.panel-heading',
        panelHeadingActive = 'panel-heading-active';
    
      $(document).on('show.bs.collapse', Selector, function (e) {
        // From the panel-group, deactive all headings
        $(e.currentTarget)
          .find(panelHeading)
          .removeClass(panelHeadingActive);
        // And activate the target heading
        $(e.target)
          .siblings(panelHeading)
          .addClass(panelHeadingActive);
      });


    // ----------------------------------------------------------
    // If you need Javascript components from the application 
    // do not include the file app.js in all your pages.
    // Find the module and paste the source here to keep the pages
    // lightweight and separated from the application source
    // !! Or even better use gulpfile.js to add modules for pages !!
    // ----------------------------------------------------------



  }); // end document ready

}(jQuery, window, document));
