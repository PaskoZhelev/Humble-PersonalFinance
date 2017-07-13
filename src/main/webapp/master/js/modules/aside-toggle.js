/**=========================================================
 * Module: aside-toggle.js
 * Toggle the aside between normal an collapsed state
 * State applied to body so all elements can be notified
 * Targeted elements must have [data-toggle="aside"]
 =========================================================*/

(function($, window, document){

  var Selector = '[data-toggle="aside"]',
      $body = $('body');

  $(document).on('click', Selector, function (e) {
      e.preventDefault();
      
      $body.toggleClass('aside-toggled');

  });

}(jQuery, window, document));
