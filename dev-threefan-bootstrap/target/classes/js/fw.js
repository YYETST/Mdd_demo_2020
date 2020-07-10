let modules = {}; env = {uname:"YonScript 5.0.1-3.11.Linux.x86_64(Iori) / Fri Jun 11 01:12:55 UTC 2019"};
function require(md,uri){
	if(!modules[md]){
		_moduleLoader__(md,uri)
	}
  return modules[md];
}
function exports(md){
  modules =   Object.assign({},modules, md)
  return modules[md];
}
function _entryPoint__(point,param){
  return require(point).call(this,param)
}
