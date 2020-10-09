var time = 1000, show = true;
$(window).scroll(function () {
    $('#counter').each(function () {
        var cPos = $(this).offset().top,
            topWindow = $(window).scrollTop();
        if(cPos < topWindow + 1000) {
            if(show === true) {
                $('.counter-numb').addClass('counter-visible');
                $('p').each(function () {
                    var i = 1,
                        num = $(this).data('num'),
                        step = 2 * time / num,
                        that = $(this),
                        int = setInterval(function () {
                            if (i <= num) {
                                that.html(i);
                            } else {
                                clearInterval(int);
                                show = false;
                            }
                            i++;
                        }, step);
                });
            }
        }
    });
});