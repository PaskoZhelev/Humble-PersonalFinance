/**
 * Provides a start point to run plugins and other scripts
 */
(function($, window, document){

  if (typeof $ === 'undefined') { throw new Error('This application\'s JavaScript requires jQuery'); }

  $(window).load(function() {

    $('.scroll-content').slimScroll({
        height: '250px'
    });

  });

  $(function() {

    // Init Fast click for mobiles
    FastClick.attach(document.body);

    // inhibits null links
    $('a[href="#"]').each(function(){
      this.href = 'javascript:void(0);';
    });

    // popover init
    $("[data-toggle=popover]")
      .popover();

    // Bootstrap slider
    $('.slider').slider();

    // Chosen
    $(".chosen-select").chosen();

    // Filestyle
    $(".filestyle").filestyle();

    // Masked inputs initialization
    $('[data-toggle="masked"]').inputmask();

  });

}(jQuery, window, document));
