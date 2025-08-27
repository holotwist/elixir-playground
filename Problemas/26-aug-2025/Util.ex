defmodule Util do
    def print_message(data) do
        IO.puts(data)
    end

    def get_message(message) do
        IO.gets(message)
    end

    def ingress(message, :number) do
        input = IO.gets("#{message}: ") |> String.trim()
        String.to_integer(input)
    end

end