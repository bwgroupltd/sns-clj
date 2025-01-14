# sns-clj

Embedded fake sns for clojure based on https://github.com/s12v/sns Just packaged to make it easy to use for mocking in clojure land

sns-clj.sqs-test.clj provides a good example of how to test and integration with sqs (using elasticmq)

## Usage

[audiogum/sns-clj "0.2.0"]

### Development:

```clojure
(require 'sns-clj.core)

;; Start a local sns with default port:
(init-sns)

;; another call will halt the previous system:
(init-sns)

;; When you're done:
(halt-sns!)
```

### Testing:

**NOTE**: these will halt running sns instances

```clojure
(require 'clojure.test)

(use-fixtures :once with-sns-fn)

(defn around-all
  [f]
  (with-sns-fn "optional file path for db.json"
                    f))

(use-fixtures :once around-all)


; You can also wrap ad-hoc code in init/halt:
(with-sns "optional file path for db.json"
  do-something) 
  ```
