defmodule NetSalary do
    def parse_number(str) do
        case Float.parse(str) do
            {num, ""} -> num
            :error ->
                case Integer.parse(str) do
                    {num, ""} -> num * 1.0
                    _ -> :error
                end
        end
    end

    def calculate(name, hours_str, rate_str)  do
        hours = String.to_integer(hours_str)
        rate = parse_number(rate_str)

        base_salary = 
            if hours > 160 do
                160 * rate
            else
                hours * rate
            end
        
        extra_hours_pay = 
            if hours > 160 do
                extra_hours = hours - 160
                extra_rate = rate * 1.25
                extra_hours * extra_rate
            else
                0
            end
        
        net_salary = base_salary + extra_hours_pay

        "El salario neto de #{name} es: $#{Float.round(net_salary, 2)}"
    end

    def run(args) do
        case args do
            [name, hours, rate] ->
                calculate(name, hours, rate)
                |> IO.puts()
            _ ->
                IO.puts("Error: Se requieren nombre, horas trabajadas y valor por hora.")
        end
    end
end

NetSalary.run(System.argv())
