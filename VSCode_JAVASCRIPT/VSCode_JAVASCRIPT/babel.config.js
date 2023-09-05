module.exports = (api) => {
    const babelEV = api.env();
    const babelVer = api.version;
    console.log(`Babel ${babelEV} -Mode : ${babelVer}`);

    const presets = [`@babel/preset-env`];
    const plugins = [];

    return {
        presets,
        plugins
    }
}