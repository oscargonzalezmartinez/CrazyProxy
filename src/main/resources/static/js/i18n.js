//internacionalizacion

app.config(['$translateProvider',function ($translateProvider) {
/*
  $translateProvider.useStaticFilesLoader({
    prefix: 'js/locale_',
	suffix:'.json'
  });*/

  $translateProvider.preferredLanguage('es');
  $translateProvider.useSanitizeValueStrategy('escaped');
}]);