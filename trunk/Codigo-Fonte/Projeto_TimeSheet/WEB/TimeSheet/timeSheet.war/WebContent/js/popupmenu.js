/***********************************************************************************************************/

jQuery(document).ready(function() {
	jQuery('.link').click(function(e){
		jQuery('#'+jQuery(this).attr('rel')).css({
	            top : (e.pageY + -6)+'px',
				left : (e.pageX + 5)+'px',
		    zIndex: 12,
                    position:'absolute'
	         }).toggle();
	});
	
});
