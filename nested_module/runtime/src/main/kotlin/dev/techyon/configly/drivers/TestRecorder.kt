package dev.techyon.configly.drivers

import io.quarkus.runtime.RuntimeValue
import io.quarkus.runtime.annotations.Recorder
import java.util.*
import java.util.logging.Handler
import java.util.logging.Level
import java.util.logging.LogRecord


@Recorder
open class AdditionalLogHandlerValueFactory {
  open fun create(): RuntimeValue<Optional<Handler>> {
    println("Recorder created")
    return RuntimeValue(Optional.of(TestHandler()))
  }

  class TestHandler : Handler() {
    val records: MutableList<LogRecord> = ArrayList()
    override fun publish(record: LogRecord) {
      records.add(record)
    }

    override fun flush() {}
    override fun getLevel(): Level {
      return Level.FINE
    }

    @Throws(SecurityException::class)
    override fun close() {
    }
  }
}