/**=========================================================
 * Module: sidebar-menu.js
 * Provides a simple way to implement bootstrap collapse plugin using a target 
 * next to the current element (sibling)
 * Targeted elements must have [data-toggle="collapse-next"]
 =========================================================*/
(function($, window, document){

  var collapseSelector = '[data-toggle="collapse-next"]',
      colllapsibles    = $('.sidebar .collapse').collapse({toggle: false}),
      toggledClass     = 'aside-toggled',
      $body            = $('body'),
      phone_mq         = 768; // media querie

  $(function() {

    $(document)
      .on('click', collapseSelector, function (e) {
          e.preventDefault();
          
          if ($(window).width() > phone_mq &&
              $body.hasClass(toggledClass)) return;

          // Try to close all of the collapse areas first
          colllapsibles.collapse('hide');
          // ...then open just the one we want
          var $target = $(this).siblings('ul');
          $target.collapse('show');

      })
      // Submenu when aside is toggled
      .on('click', '.sidebar > .nav > li', function() {

        if ($body.hasClass(toggledClass) &&
          $(window).width() > phone_mq) {

            $('.sidebar > .nav > li')
              .not(this)
              .removeClass('open')
              .end()
              .filter(this)
              .toggleClass('open');
        }

      });

  });


}(jQuery, window, document));
