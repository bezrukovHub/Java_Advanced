/**
 * Created by admin on 13.12.2016.
 */

(function($){
    $(function(){
        // scroll is still position
        var scroll = $(document).scrollTop();
        var headerHeight = $('.page-header').outerHeight();
        //console.log(headerHeight);

        $(window).scroll(function() {
            // scrolled is new position just obtained
            var scrolled = $(document).scrollTop();

            // optionally emulate non-fixed positioning behaviour

            if (scrolled > headerHeight){
                $('.page-header').addClass('off-canvas');
            } else {
                $('.page-header').removeClass('off-canvas');
            }

            if (scrolled > scroll){
                // scrolling down
                $('.page-header').removeClass('fixed');
            } else {
                //scrolling up
                $('.page-header').addClass('fixed');
            }

            scroll = $(document).scrollTop();
        });


    });
})(jQuery);
