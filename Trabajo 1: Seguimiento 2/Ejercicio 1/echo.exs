defmodule Echo do
    def run(args) do
        # Toma el primer argumento de la lista, si existe
        message = List.first(args) || ""

        # Convierte el mensaje a mayúsculas y lo imprime
        String.upcase(message)
        |> IO.puts()
    end
end

# Llama a la función run con los argumentos de la línea de comandos
Echo.run(System.argv())