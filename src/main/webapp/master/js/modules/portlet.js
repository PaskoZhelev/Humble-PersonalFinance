/**=========================================================
 * Module: portlet.js
 * Drag and drop any panel to change its position
 * The Selector should could be applied to any object that contains
 * panel, so .col-* element are ideal.
 =========================================================*/

(function($, window, document){

  // Component is optional
  if(!$.fn.sortable) return;

  var Selector = '[data-toggle="portlet"]';

  $(function(){

    $( Selector ).sortable({
      connectWith:  Selector,
      items:        'div.panel',
      handle:       '.portlet-handler',
      opacity:      0.7,
      placeholder:  'portlet box-placeholder',
      cancel:       '.portlet-cancel',
      forcePlaceholderSize: true,
      iframeFix:  false,
      tolerance:  'pointer',
      helper:     'original',
      revert:     200,
      forceHelperSize: true,

    }).disableSelection();

  });

}(jQuery, window, document));

