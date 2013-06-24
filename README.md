# clj-wamp

A Leiningen template for a minimal WAMP WebSocket server with HTTP Kit and clj-wamp.

## Usage

Create a new clj-wamp project with leiningen:

```bash
% lein new clj-wamp my-project-name
% cd my-project-name
% lein run
```
...and open browser to [localhost:8080](http://localhost:8080)

## Project Structure

```
wamptutorial
├── README.md
├── project.clj
├── resources
│   └── public
│       └── index.html
├── resources-dev
│   ├── config.clj
│   └── log4j.properties
└── src
    └── wamptutorial
        ├── config.clj
        ├── main.clj
        ├── routes.clj
        └── websocket.clj
```

## Development

One-time setup:
 1. Clone this repo
 2. Add the following to your `~/.lein/profiles.clj` user plugins: `[clj-wamp/lein-template "0.1.0-SNAPSHOT"]`

Test/Dev cycle:
 1. Run `lein install`
 2. In a temp directory, run `lein new clj-wamp testcljwamp`
 3. Try running the new project: `lein run`

## Thanks

Template code is based off of [HTTP Kit's lein template](https://github.com/http-kit/lein-template).

## License

Copyright © 2013 Christopher Martin

Distributed under the Eclipse Public License, the same as Clojure.
