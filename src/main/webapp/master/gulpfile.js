var gulp        = require('gulp'),
    concat      = require('gulp-concat'),
    uglify      = require('gulp-uglify'),
    jade        = require('gulp-jade'),
    less        = require('gulp-less'),
    path        = require('path'),
    livereload  = require('gulp-livereload'), // Livereload plugin needed: https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei
    embedlr     = require("gulp-embedlr"),
    tinylr      = require('tiny-lr'),
    marked      = require('marked'), // For :markdown filter in jade
    path        = require('path'),
    changed     = require('gulp-changed'),
    prettify    = require('gulp-html-prettify'),
    htmlhint    = require("gulp-htmlhint"),
    server      = tinylr();

// LiveReload port. Change it only if there's a conflict
var lvr_port = 35729;

//  Edit here the modules scripts 
//  that will be used in the pages
var pageScripts = [
    'js/modules/utils.js',
    'js/modules/play-animations.js',
    'js/pages.init.js'
];

// SOURCES CONFIG 
var source = {
  scripts: {
    app:    ['js/modules/*.js', 'js/app.init.js'],
    pages:  pageScripts
  },
  templates: {
    app: {
        files : ['jade/*.jade', '!jade/pages/*.jade', '!jade/layout/page-layout.jade'],
        watch: ['jade/**/*.jade', 'jade/*.jade', '!jade/pages/*.jade', '!jade/layout/page-layout.jade']
    },
    pages: {
        files : ['jade/pages/*.jade'],
        watch: ['jade/pages/*.jade', 'jade/layout/page-layout.jade']
    }
  },
  styles: {
    app: {
      main: ['less/app.less', '!less/pages/*.less'],
      dir:  'less',
      watch: ['less/*.less', 'less/**/*.less', '!less/pages/*.less']
    },
    pages: {
      main: 'less/pages/*.less',
      dir:  'less/pages',
      watch: ['less/pages/*.less']
    }
  },
  bootstrap: {
    main: 'less/bootstrap/bootstrap.less',
    dir:  'less/bootstrap',
    watch: ['less/bootstrap/*.less']
  }
};

// BUILD TARGET CONFIG 
var build = {
  scripts: {
    app: {
      main: 'app.js',
      dir: '../app/js'
    },
    pages: {
      main: 'pages.js',
      dir: '../app/js'
    }
  },
  styles: '../app/css',
  templates: {
    app: '..',
    pages: '../pages'
  }
};


// Error handler
function handleError(err) {
  console.log(err.toString());
  this.emit('end');
}


//---------------
// TASKS
//---------------


// JS APP
gulp.task('scripts-app', function() {
    // Minify and copy all JavaScript (except vendor scripts)
    return gulp.src(source.scripts.app)
        //.pipe(uglify())  /* UNCOMMENT TO MINIFY * /
        .pipe(concat(build.scripts.app.main))
        .pipe(gulp.dest(build.scripts.app.dir))
        .pipe( livereload( server ));
});

// JS PAGES
gulp.task('scripts-pages', function() {
    // Minify and copy all JavaScript (except vendor scripts)
    return gulp.src(source.scripts.pages)
        //.pipe(uglify())  /* UNCOMMENT TO MINIFY * /
        .pipe(concat(build.scripts.pages.main))
        .pipe(gulp.dest(build.scripts.pages.dir))
        .pipe( livereload( server ));
});

// LESS
gulp.task('styles-app', function() {
    return gulp.src(source.styles.app.main)
        .pipe(less({
            paths: [source.styles.app.dir]
        }))
        .on("error", handleError)
        .pipe(gulp.dest(build.styles))
        .pipe( livereload( server ));
});

// LESS PAGES
gulp.task('styles-pages', function() {
    return gulp.src(source.styles.pages.main)
        .pipe(less({
            paths: [source.styles.pages.dir]
        }))
        .on("error", handleError)
        .pipe(gulp.dest(build.styles))
        .pipe( livereload( server ));
});

// BOOSTRAP
gulp.task('bootstrap', function() {
    return gulp.src(source.bootstrap.main)
        .pipe(less({
            paths: [source.bootstrap.dir]
        }))
        .on("error", handleError)
        .pipe(gulp.dest(build.styles))
        .pipe( livereload( server ));
});

// JADE
gulp.task('templates-app', function() {
    return gulp.src(source.templates.app.files)
        //.pipe(changed(build.templates, { extension: '.html' }))
        .pipe(jade({
            //pretty: true
        }))
        .on("error", handleError)
        .pipe(prettify({
            indent_char: ' ',
            indent_size: 3,
            unformatted: ['a', 'sub', 'sup', 'b', 'i', 'u']
        }))
        //.pipe(embedlr())                    /* UNCOMMENT TO ENALBE LIVERELOAD */
        .pipe(htmlhint())
        .pipe(htmlhint.reporter())
        .pipe(gulp.dest(build.templates.app))
        //.pipe( livereload( server ) )      /* UNCOMMENT TO ENALBE LIVERELOAD */
        ;
});

// JADE
gulp.task('templates-pages', function() {
    return gulp.src(source.templates.pages.files)
        //.pipe(changed(build.pages, { extension: '.html' }))
        .pipe(jade({
            //pretty: true
        }))
        .on("error", handleError)
        .pipe(prettify({
            indent_char: ' ',
            indent_size: 3,
            unformatted: ['a', 'sub', 'sup', 'b', 'i', 'u']
        }))
        //.pipe(embedlr())                    /* UNCOMMENT TO ENALBE LIVERELOAD */
        .pipe(htmlhint())
        .pipe(htmlhint.reporter())
        .pipe(gulp.dest(build.templates.pages))
        //.pipe( livereload( server ) )      /* UNCOMMENT TO ENALBE LIVERELOAD */
        ;
});


//---------------
// WATCH
//---------------

// Rerun the task when a file changes
gulp.task('watch', function() {
  try {
      server.listen(
        lvr_port,
        function (err) {
        
          if (err) { return console.log(err); }

          gulp.watch(source.scripts.app,             ['scripts-app']);
          gulp.watch(source.scripts.pages,           ['scripts-pages']);
          gulp.watch(source.styles.app.watch,        ['styles-app']);
          gulp.watch(source.styles.pages.watch,      ['styles-pages']);
          gulp.watch(source.bootstrap.watch,         ['bootstrap']);
          gulp.watch(source.templates.pages.watch,   ['templates-pages']);
          gulp.watch(source.templates.app.watch,     ['templates-app']);
      
      });
  }
  catch(e) {
    console.log(e);
  }

});

//---------------
// DEFAULT TASK
//---------------

gulp.task('default', [
          'scripts-app',
          'scripts-pages',
          'bootstrap',
          'styles-app',
          'styles-pages',
          'templates-app',
          'templates-pages',
          'watch'
        ]);
