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

Application defaults are supplied by environment-based configuration
found within `./resources-dev/config.clj`.

Run via REPL:

```bash
% lein repl
...
{{sanitized-ns}}.main=> (start-server) ; starts/restarts the server
{{sanitized-ns}}.main=> (stop-server)
```

## License

Copyright © {{year}} FIXME

Distributed under the Eclipse Public License, the same as Clojure.
