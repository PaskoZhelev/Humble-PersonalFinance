/**=========================================================
 * Module: navbar-search.js
 * Navbar search toggler
 * To open search add a buton with [data-toggle="navbar-search"]
 * To close search add an element with [data-toggle="navbar-search-dismiss"]
 *
 * Auto dismiss on ESC key
 =========================================================*/

(function($, window, document){
  
  $(function() {

    var openSelector    = '[data-toggle="navbar-search"]',
        dismissSelector = '[data-toggle="navbar-search-dismiss"]',
        inputSelector   = '.navbar-form input[type="text"]',
        navbarForm      = $('form.navbar-form');

    var NavSearch = {
      toggle: function() {
        
        navbarForm.toggleClass('open');
        
        var isOpen = navbarForm.hasClass('open');
        
        navbarForm.find('input')[isOpen ? 'focus' : 'blur']();

      },

      dismiss: function() {
        navbarForm
          .removeClass('open')      // Close control
          .find('input[type="text"]').blur() // remove focus
          .val('')                    // Empty input
          ;
      }

    };

    $(document)
        .on("click", NavSearch.dismiss)
        .on("click", openSelector +', '+ inputSelector +', '+ dismissSelector, function (e) {
          e.stopPropagation();
        })
        .on("click", dismissSelector, NavSearch.dismiss)
        .on("click", openSelector, NavSearch.toggle)
        .keyup(function(e) {
          if (e.keyCode == 27) // ESC
            NavSearch.close();
        });
  });


}(jQuery, window, document));
