# {{name}}

FIXME

## Usage

```bash
% lein run -- --help
Usage:

 Switches           Default  Desc
 --------           -------  ----
 -i, --ip                    The ip address to bind to
 -p, --port                  Port to listen
 -t, --thread                Http worker thread count
 --no-help, --help  false    Print this help
```

Run with application defaults:

```bash
% lein run
```
...then point browser to [localhost:8080](http://localhost:8080)

Application defaults are supplied by environment-based configuration
found within `./resources-dev/config.clj`.

Dev lifecycle via REPL:

 1. Start up a REPL: `lein repl`
 2. Load the app:

```bash
testwamp2.main=> (use '[clojure.tools.namespace.repl :only (refresh)])
testwamp2.main=> (refresh)
testwamp2.main=> (start-server) ; starts/restarts the server
```
 3. Test it out: [localhost:8080](http://localhost:8080)
 4. Modify some source files (.clj)
 5. Restart:

```bash
testwamp2.main=> (stop-server)
testwamp2.main=> (refresh)
testwamp2.main=> (start-server)
```

## License

Copyright © {{year}} FIXME

Distributed under the Eclipse Public License, the same as Clojure.
