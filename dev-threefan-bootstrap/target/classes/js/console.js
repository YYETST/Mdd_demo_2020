;class Console {
    // TRACE
    log() {
        _ConsoleTrace_.apply(this,arguments);
    }

    // DEBUG
    debug() {
        _ConsoleDebug_.apply(this,arguments);
    }

    // INFO
    info() {
        _ConsoleInfo_.apply(this,arguments);
    }

    // WARN
    warn() {
        _ConsoleWarn_.apply(this,arguments);
    }

    // ERROR
    error() {
        _ConsoleError_.apply(this,arguments);
    }
}

var console = (function () {
    return new Console();
})();