package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {
    private static final BulldozerProducer BULLDOZER_PRODUCER = new BulldozerProducer();
    private static final ExcavatorProducer EXCAVATOR_PRODUCER = new ExcavatorProducer();
    private static final TruckProducer TRUCK_PRODUCER = new TruckProducer();

    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        if (Objects.equals(type, Bulldozer.class)) {
            return new ArrayList<>(BULLDOZER_PRODUCER.get());
        } else if (Objects.equals(type, Excavator.class)) {
            return new ArrayList<>(EXCAVATOR_PRODUCER.get());
        } else if (Objects.equals(type, Truck.class)) {
            return new ArrayList<>(TRUCK_PRODUCER.get());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
