$(document).ready(function() {
	$(window).resize(function() {
		yo_screen_resize();
	});
	yo_screen_resize();
});

function yo_screen_resize() {
	var sw = $(window).width();
	if (sw >= 1280) {
		yo_screen_1280();
	} else if (sw >= 960) {
		yo_screen_960();
	} else if (sw >= 854) {
		yo_screen_854();
	} else if (sw >= 800) {
		yo_screen_800();
	} else if (sw >= 720) {
		yo_screen_720();
	} else if (sw >= 640) {
		yo_screen_640();
	} else if (sw >= 600) {
		yo_screen_600();
	} else if (sw >= 540) {
		yo_screen_540();
	} else if (sw >= 480) {
		yo_screen_480();
	} else if (sw >= 360) {
		yo_screen_360();
	} else if (sw >= 320) {
		yo_screen_320();
	} else if (sw >= 240) {
		yo_screen_240();
	} else {
		yo_screen_240();
	}
	yo_screen_changed();
}

function yo_noscreen() {
	$('#yo-screen').toggleClass('yo-screen-1280', false);
	$('#yo-screen').toggleClass('yo-screen-960', false);
	$('#yo-screen').toggleClass('yo-screen-854', false);
	$('#yo-screen').toggleClass('yo-screen-800', false);
	$('#yo-screen').toggleClass('yo-screen-720', false);
	$('#yo-screen').toggleClass('yo-screen-640', false);
	$('#yo-screen').toggleClass('yo-screen-600', false);
	$('#yo-screen').toggleClass('yo-screen-540', false);
	$('#yo-screen').toggleClass('yo-screen-480', false);
	$('#yo-screen').toggleClass('yo-screen-360', false);
	$('#yo-screen').toggleClass('yo-screen-320', false);
	$('#yo-screen').toggleClass('yo-screen-240', false);
}

function yo_screen_1280() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-1280', true);
	yo_screen_changed_1280();
}

function yo_screen_960() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-960', true);
	yo_screen_changed_960();
}

function yo_screen_854() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-854', true);
	yo_screen_changed_854();
}

function yo_screen_800() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-800', true);
	yo_screen_changed_800();
}

function yo_screen_720() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-720', true);
	yo_screen_changed_720();
}

function yo_screen_640() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-640', true);
	yo_screen_changed_640();
}

function yo_screen_600() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-600', true);
	yo_screen_changed_600();
}

function yo_screen_540() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-540', true);
	yo_screen_changed_540();
}

function yo_screen_480() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-480', true);
	yo_screen_changed_480();
}

function yo_screen_360() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-360', true);
	yo_screen_changed_360();
}

function yo_screen_320() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-320', true);
	yo_screen_changed_320();
}

function yo_screen_240() {
	yo_noscreen();
	$('#yo-screen').toggleClass('yo-screen-240', true);
	yo_screen_changed_240();
}
