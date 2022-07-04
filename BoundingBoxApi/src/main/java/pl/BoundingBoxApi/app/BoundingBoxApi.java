package pl.BoundingBoxApi.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boundingBoxes")
public class BoundingBoxApi {

    private final BoundingBoxManager boundingBoxManager;

    @Autowired
    public BoundingBoxApi(BoundingBoxManager boundingBoxManager)
    {
        this.boundingBoxManager = boundingBoxManager;
    }

    @GetMapping("/all")
    public List<BoundingBox> getAll() {
        return boundingBoxManager.getBoundingBoxesList();
    }

    @GetMapping("/byId")
    public void GetBoundingBoxById(@RequestParam String id)
    {
        boundingBoxManager.GetBoundingBoxById(id);
    }

    @PostMapping("/add")
    public void addBox(@RequestBody BoundingBox boundingBox) {
        boundingBoxManager.AddBoundingBox(boundingBox);
    }
    @PutMapping
    public void updateBoundingBox(@RequestBody BoundingBox boundingBox)
    {
        boundingBoxManager.EditBoundingBox(boundingBox);
    }

    @DeleteMapping
    public void deleteBoundingBox(@RequestParam String id) {
        boundingBoxManager.RemoveBoundingBox(id);
    }



}
