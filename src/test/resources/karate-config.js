function fn() {
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);
  var port = karate.properties['application.server.port'] || '8080';
  var protocol = 'http';
  if (karate.properties['application.server.https'] === 'true') {
    protocol = 'https';
    karate.configure('ssl', true);
  }
  var config = { baseUrl: protocol + '://127.0.0.1:' + port };
  return config;
}
