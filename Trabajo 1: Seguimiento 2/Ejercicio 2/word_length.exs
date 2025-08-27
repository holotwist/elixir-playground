defmodule WordLength do
    def run(args) do
        # Toma el primer argumento de la lista, si existe
        word = List.first(args) || ""

        # Calcula la longitud de la cadena y la imprime
        String.length(word)
        |> IO.puts()
    end
end

WordLength.run(System.argv())