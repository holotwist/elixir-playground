defmodule TiendaCellStore do
    def main do
        precio_producto = Util.ingress("Jelou, ingrese valor del producto", :number)
        descuento = Util.ingress("Ingrese el porcentaje de descuento (0-100)", :number)

        IO.puts("El precio con descuento aplicado es: #{precio_producto * (descuento / 100)}")
    end
end

TiendaCellStore.main()