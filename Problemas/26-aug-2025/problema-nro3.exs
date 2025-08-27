defmodule CalculadoraDevuelta do
    def main do
        valor_total = Util.ingress("Ingrese valor total de la factura", :number)
        valor_dado = Util.ingress("Ingrese valor dado por el cliente", :number)

        if valor_dado < valor_total do
            IO.puts("No es suficiente para pagar")
        else
            total_devuelta = valor_dado - valor_total
            IO.puts("Debe hacer una devuelta de #{total_devuelta}")
        end
    end
end

CalculadoraDevuelta.main()