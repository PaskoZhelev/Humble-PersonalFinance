/**=========================================================
 * Module: table-checkall.js
 * Tables check all checkbox
 =========================================================*/

(function($, window, document){
  
  var Selector = 'th.check-all';

  $(Selector).on('change', function() {
    var $this = $(this),
        index= $this.index() + 1,
        checkbox = $this.find('input[type="checkbox"]'),
        table = $this.parents('table');
    // Make sure to affect only the correct checkbox column
    table.find('tbody > tr > td:nth-child('+index+') input[type="checkbox"]')
      .prop('checked', checkbox[0].checked);

  });

}(jQuery, window, document));
