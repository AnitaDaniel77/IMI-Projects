// grab the canvas on the page
var canvas = document.getElementsByTagName("canvas")[0];

// get the 2D drawing tool
var context = canvas.getContext("2d");

// filled square, top-left corner, 100 x 100
context.fillRect(0, 0, 100, 100);