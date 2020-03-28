$(document).ready(function() {
    var fastbannerform_status_tlb = true;

    $("#toolbarCollapseOpenAccount .fastbannerform__country").select2({
        templateResult: formatState,
        templateSelection: formatState,
        dropdownParent: $('body > header')
    });

    $('body').on('click', '#toolbarCollapseOpenAccount .fastbannerform__flex__close span', function(){
        $('.fastbannerform__login').hide();
        $('.fastbannerform__formcontent').show();

        $('.fastbannerform__form input[type="text"]').val('');
        $('.fastbannerform__form input[type="checkbox"]').removeAttr("checked");
    });

    $('body').on('click', '#toolbarCollapseOpenAccount .fastbannerform__flex__botton button', function(){
        var block = $(this),
            preloader = $('#toolbarCollapseOpenAccount form .btn-preloader'),
            blockform = $(this).parents('.fastbannerform__form');

        if(fastbannerform_status_tlb){
            blockform.find('.fastbannerform__flex__input input').removeClass('fastbannerform__red');

            fastbannerform_status_tlb = false;
            blockform.find('.fastbannerform__error').hide();
            blockform.find('.fastbannerform__error, .fastbannerform__logincount').html('');

            $.ajax({
                url: root_http + 'fast_open_live_account.php',
                type: "POST",
                data: blockform.serialize(),
                dataType: 'json',
                beforeSend: function() {
                    block.hide();
                    preloader.show();
                },
                success: function(ret) {
                    if (!ret.error) {
                        $.ajax({
                            type: "POST",
                            url: "https://client-api.instaforex.com/api/openaccount/anonymous",
                            data: ret,
                            dataType: 'json',
                            success: function(ret){
                                blockform.find('.fastbannerform__formcontent, .fastbannerform__error').hide();
                                blockform.find('.fastbannerform__login').show();
                                blockform.find('.fastbannerform__logincount').html(ret.Login);

                                block.show();
                                preloader.hide();
                                fastbannerform_status_tlb = true;
                            }
                        });
                    } else {
                        if (typeof ret.alert == 'object') {
                            $.each(ret.alert, function(key, val) {
                                blockform.find('input[name="' + key + '"]').addClass('fastbannerform__red');
                                blockform.find('.fastbannerform__error').html(blockform.find('.fastbannerform__error').html() + '<div>' + val + '</div>');
                            });

                            blockform.find('.fastbannerform__error').show();
                        } else if (typeof ret.alert == 'string') {
                            blockform.find('.fastbannerform__error').html(ret.alert);
                        }

                        block.show();
                        preloader.hide();
                        fastbannerform_status_tlb = true;
                    }

                    var top = $('header').height() + $('.breadcrumbs').height() + $('.fastbannerform__page').height();
                    $('.sidebar-left, .sidebar-right').css('top', top + 'px');
                }
            });
        }

        return false;
    });

});

function formatState(state){
    if(!state.id){return state.text;}
    var stateline = $('<span class="fastbannerform__span f32 NOFLAG ' + state.title + '"></span> <span class="fastbannerform__span">' + state.text + '</span>');
    return stateline;
}
$(document).ready(function(){

    /**
     * input Search focusIn
     */
    $('body > header #toolbarCollapseSearch input[type="search"]').focusin(function() {
        $('button[type="submit"]', $(this).parent()).addClass('active');
    });
    /**
     * input Search focusOut
     */
    $('body > header #toolbarCollapseSearch input[type="search"]').focusout(function() {
        $('button[type="submit"]', $(this).parent()).removeClass('active');
    });

    /**
     * all toolbarCollapse before show
     */
    $('[id^="toolbarCollapse"]').on('show.bs.collapse', function () {
        toolbarHideAllCollapse();
        closeNMenu();
    });

    $('#toolbarCollapsePartnerCabinet .main-block > button').on('click', function (e) {
        $('#toolbarCollapsePartnerCabinet .main-block > button').not($(this)).removeClass('active');
        $(this).addClass('active');

        $('#toolbarCollapsePartnerCabinet .main-block > .collapse').hide();
        $('#' + $(this).data('target')).show();

        $('#toolbarCollapsePartnerCabinet .promo-block > div').removeClass('active');
        $('#toolbarCollapsePartnerCabinet .promo-block > div[data-id="' + $(this).data('target') + '"]').addClass('active');

        $('#toolbarCollapsePartnerCabinet .image-block > img').attr('src', $(this).data('image-block_image'));

    });

    /**
     * click вне тулбара
     */
    $(document).mouseup(function(e){
        if($('body > header').has(e.target).length === 0 && $(e.target).parents('.select2-container').length === 0){
            toolbarHideAllCollapse();
        }
    });

    /**
     * Скрывать туулбар, если проматали несколько экранов вниз
     */
    window.onscroll = function() {
        if(window.pageYOffset > ($('body > header').height() + (3 * $(window).height()))){
            toolbarHideAllCollapse();
        }
    };

    /**
     * mobile menu_icon click
     */
    $('button.main_nav_menu_icon').on('click', function(e){
        e.preventDefault();
        collapseNMenu();
    });

    /**
     *
     */
    $('#main_nav_menu > ul > li > a[data-target]').on('click', function(e) {
        e.preventDefault();

        var block = $(this).parent().parent();
        var next_block = $('#main_nav_menu > ul[data-name="' + $(this).data('target') + '"]');

        // анемируем следующий
        next_block.addClass('active animated slideInRight');
        // анимируем текущий
        block.addClass('closing animated slideOutLeft');
        setTimeout(function(){
            // скрываем текущий
            block.removeClass('closing active animated slideOutLeft');
            // убираем анимацию со следующего
            next_block.removeClass('animated slideInRight');
        }, 800);

    });

});

function collapseNMenu(){
    if(!$('body > header .nheader button.main_nav_menu_icon').hasClass('active')){
        closeNMenu();
    } else {
        showNMenu();
    }
}

function showNMenu(){
    toolbarHideAllCollapse();
    $('body > header .nheader button.main_nav_menu_icon').addClass('active');
    $('#main_nav_menu').addClass('active');
}

function closeNMenu(){
    $('body > header .nheader button.main_nav_menu_icon').removeClass('active');
    $('#main_nav_menu').removeClass('active');
}

function toolbarHideAllCollapse(){
    $('[id^="toolbarCollapse"]').collapse('hide');
}
var fastbannerform_status = true;

$(document).ready(function() {
    $('.fio__upper').on("input propertychange paste focusout",function(){for(var parts=$(this).val().split(" "),i=0;i<parts.length;i++)parts[i]=parts[i].charAt(0).toUpperCase()+parts[i].substring(1).toLowerCase();$(this).val(parts.join(" "))});

    $(".fastbannerform__country").select2({
        templateResult: formatState,
        templateSelection: formatState
    });

    $('body').on('click', '[data-openaccount-page] button', function(){
        var block = $(this),
            text = $(this).html(),
            blockform = $(this).parents('.fastbannerform__form');

        if(fastbannerform_status){
            blockform.find('.fastbannerform__flex__input input').removeClass('fastbannerform__red');

            fastbannerform_status = false;
            blockform.find('.fastbannerform__error').hide();
            blockform.find('.fastbannerform__error, .fastbannerform__logincount').html('');

            $.ajax({
                url: root_http + 'fast_open_live_account.php',
                type: "POST",
                data: blockform.serialize(),
                dataType: 'json',
                beforeSend: function() {
                    block.html('<i class="preloader_white_mini" style="margin: 0 auto;"></i>');
                },
                success: function(ret) {
                    if (!ret.error) {
                        $.ajax({
                            type: "POST",
                            url: "https://client-api.instaforex.com/api/openaccount/anonymous",
                            data: ret,
                            dataType: 'json',
                            success: function(ret){
                                blockform.find('.fastbannerform__formcontent, .fastbannerform__error').hide();
                                blockform.find('.fastbannerform__login').show();
                                blockform.find('.fastbannerform__logincount').html(ret.Login);

                                block.html(text);
                                fastbannerform_status = true;
                            }
                        });
                    } else {
                        if (typeof ret.alert == 'object') {
                            $.each(ret.alert, function(key, val) {
                                blockform.find('input[name="' + key + '"]').addClass('fastbannerform__red');
                                blockform.find('.fastbannerform__error').html(blockform.find('.fastbannerform__error').html() + '<div>' + val + '</div>');
                            });

                            blockform.find('.fastbannerform__error').show();
                        } else if (typeof ret.alert == 'string') {
                            blockform.find('.fastbannerform__error').html(ret.alert);
                        }

                        block.html(text);
                        fastbannerform_status = true;
                    }
                }
            });
        }

        return false;
    });

    $('body').on('click', '.fastbannerform__flex__close span', function(){
        $('.fastbannerform__login').hide();
        $('.fastbannerform__formcontent').show();

        $('.fastbannerform__form input[type="text"]').val('');
        $('.fastbannerform__form input[type="checkbox"]').removeAttr("checked");
    });
});

function formatState(state){
    if(!state.id){return state.text;}
    var stateline = $('<span class="fastbannerform__span f32 NOFLAG ' + state.title + '"></span> <span class="fastbannerform__span">' + state.text + '</span>');
    return stateline;
}